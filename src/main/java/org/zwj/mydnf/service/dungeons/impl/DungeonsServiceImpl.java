package org.zwj.mydnf.service.dungeons.impl;

import org.springframework.stereotype.Service;
import org.zwj.mydnf.entity.Dungeons;
import org.zwj.mydnf.mapper.DungeonsMapper;
import org.zwj.mydnf.service.base.impl.BaseServiceImpl;
import org.zwj.mydnf.service.dungeons.IDungeonsService;

@Service
public class DungeonsServiceImpl extends BaseServiceImpl<Dungeons, DungeonsMapper> implements IDungeonsService {
}
