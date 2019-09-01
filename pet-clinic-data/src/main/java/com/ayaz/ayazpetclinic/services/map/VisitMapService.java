package com.ayaz.ayazpetclinic.services.map;

import com.ayaz.ayazpetclinic.model.Visit;
import com.ayaz.ayazpetclinic.services.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit object) {
        if (object.getPet() == null || object.getPet().getOwner() == null ||
                object.getPet().getId() == null || object.getPet().getOwner().getId() == null) {
            throw new RuntimeException("There is no such a visit");
        }

        return super.save(object);


    }
}
