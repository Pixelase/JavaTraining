package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.services.common.EntityUtils;
import com.github.pixelase.webproject.services.common.GenericServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class BrigadeServiceTest extends GenericServiceTest<Brigade, Integer, BrigadeService> {

    @Override
    protected Brigade generateEntity() {
        return entityUtils.generateBrigade();
    }

    @Override
    protected Iterable<? extends Brigade> generateEntities(int entitiesCount) {
        List<Brigade> list = new ArrayList<>();

        for (int i = 0; i < entitiesCount; i++) {
            list.add(generateEntity());
        }

        return list;
    }

    @Test
    public void deleteBrigadeByWorkRequestTest() {
        Brigade saved = service.save(entity);
        Brigade deleted = service.delete(entity.getWorkRequest());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void deleteAllBrigadesByRealDateTest() {
        List<Brigade> brigades = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            brigades.add(new Brigade(entity.getWorkRequest(), entity.getRealDate()));
        }

        List<Brigade> saved = service.save(brigades);
        List<Brigade> deleted = service.deleteAll(entity.getRealDate());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void findAllBrigadesByRealDateTest() {
        List<Brigade> brigades = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            brigades.add(new Brigade(entity.getWorkRequest(), entity.getRealDate()));
        }

        List<Brigade> saved = service.save(brigades);
        List<Brigade> found = service.findAll(entity.getRealDate());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneBrigadeByWorkRequestTest() {
        Brigade saved = service.save(entity);
        Brigade found = service.findOne(entity.getWorkRequest());

        Assert.assertEquals(saved, found);
    }
}
