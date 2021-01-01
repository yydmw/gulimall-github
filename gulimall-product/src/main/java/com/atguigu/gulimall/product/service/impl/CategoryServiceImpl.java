package com.atguigu.gulimall.product.service.impl;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;
import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryBrandRelationService;
import com.atguigu.gulimall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author lzh
 * @Date 2020/10/12 19:02
 * @Description
 **/
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public void removeMenuByIds(List<Long> asList) {
        // TODO 检查当前的菜单是否被别的地方所引用
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] findCategoryPath(Long categoryId) {
        List<Long> paths = new ArrayList<>();
        List<Long> categoryPath = findParentPath(categoryId, paths);
        Collections.reverse(categoryPath);
        return categoryPath.toArray(new Long[0]);
    }

    /**
     * 级联更新所有关联的数据
     * @param category
     */
    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(),category.getName());
    }

    // 递归收集当前节点的父节点
    private List<Long> findParentPath(Long categoryId, List<Long> paths) {
        paths.add(categoryId);
        CategoryEntity category = this.getById(categoryId);
        // 这个判空有点呆
        if (null != category && null!=category.getCatId() && 0 != category.getParentCid()) {
            findParentPath(category.getParentCid(), paths);
        }
        return paths;
    }

    /**
     * 删除
     */
    // TODO 待写
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        // TODO 研究一下下面这行
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        //2、组装成父子的树形结构

        //2.1）、找到所有的一级分类
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0
        ).map((menu) -> {
            menu.setChildren(getChildrens(menu, entities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return (Optional.ofNullable(menu1.getSort()).orElseGet(() -> 0) - Optional.ofNullable(menu2.getSort()).orElseGet(() -> 0));
        }).collect(Collectors.toList());
        return level1Menus;
    }

    /**
     * 递归查找所有菜单的子菜单
     */
    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {

        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            //1、找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            //2、菜单的排序 j8判空给默认值
            return (Optional.ofNullable(menu1.getSort()).orElseGet(() -> 0) - Optional.ofNullable(menu2.getSort()).orElseGet(() -> 0));
        }).collect(Collectors.toList());

        return children;
    }
}