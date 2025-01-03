package net.csibio.labic.controller;

import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.Asset;
import net.csibio.labic.domain.db.Publication;
import net.csibio.labic.repository.AssetRepository;
import net.csibio.labic.repository.PublicationRepository;
import net.csibio.labic.utils.PublicationUtil;
import org.jbibtex.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    AssetRepository assetRepository;

    @RequestMapping(value = "/list")
    Result list(Asset query, int current, int pageSize) {
        Pageable pageable = PageRequest.of(current - 1, pageSize);
        Example<Asset> example = Example.of(query, query.buildMatcher());
        Page<Asset> pageableList = assetRepository.findAll(example, pageable);
        return Result.OK(pageableList.getContent(), pageableList.getNumber(), pageableList.getTotalPages());
    }

    @PostMapping("/add")
    public Result add(Asset asset) {
        assetRepository.save(asset);
        return Result.OK();
    }

    @GetMapping(value = "/remove")
    Result remove(@RequestParam(name = "ids") List<String> ids) {
        assetRepository.deleteAllById(ids);
        return Result.OK();
    }
}
