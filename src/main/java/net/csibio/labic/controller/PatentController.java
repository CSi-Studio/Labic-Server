package net.csibio.labic.controller;

import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.Asset;
import net.csibio.labic.domain.db.Patent;
import net.csibio.labic.repository.AssetRepository;
import net.csibio.labic.repository.PatentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patent")
public class PatentController {

    @Autowired
    PatentRepository patentRepository;

    @RequestMapping(value = "/list")
    Result list(Patent query, int current, int pageSize) {
        Pageable pageable = PageRequest.of(current - 1, pageSize);
        Example<Patent> example = Example.of(query, query.buildMatcher());
        Page<Patent> pageableList = patentRepository.findAll(example, pageable);
        return Result.OK(pageableList.getContent(), pageableList.getNumber(), pageableList.getTotalPages());
    }

    @PostMapping("/add")
    public Result add(Patent patent) {
        patentRepository.save(patent);
        return Result.OK();
    }

    @GetMapping(value = "/remove")
    Result remove(@RequestParam(name = "ids") List<String> ids) {
        patentRepository.deleteAllById(ids);
        return Result.OK();
    }
}
