package org.zwj.mydnf.service.base.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zwj.mydnf.service.base.IBaseService;

import java.util.Collection;
import java.util.List;

@Service
public abstract class BaseServiceImpl<T, M extends BaseMapper<T>> implements IBaseService<T> {

    @Autowired
    protected M mapper;

    @Override
    public List<T> list() {
        return mapper.selectList(null);
    }

    @Override
    public List<T> selectBatchIds(Collection<Long> ids) {
        return mapper.selectBatchIds(ids);
    }

    @Override
    public Page<T> page(Page<T> page) {
        return mapper.selectPage(page, null);
    }

    @Override
    public T get(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public void insert(T t) {
        mapper.insert(t);
    }

    @Override
    public void update(T t) {
        mapper.updateById(t);
    }

    @Override
    public void delete(Long id) {
        mapper.deleteById(id);
    }

}
