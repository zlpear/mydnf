package org.zwj.mydnf.service.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Collection;
import java.util.List;

public interface IBaseService<T> {

    List<T> list();

    List<T> selectBatchIds(Collection<Long> ids);

    Page<T> page(Page<T> page);

    T get(Long id);

    void insert(T t);

    void update(T t);

    void delete(Long id);
}
