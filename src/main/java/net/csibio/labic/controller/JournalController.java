package net.csibio.labic.controller;

import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.Asset;
import net.csibio.labic.domain.db.Journal;
import net.csibio.labic.repository.AssetRepository;
import net.csibio.labic.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    JournalRepository journalRepository;

    @RequestMapping(value = "/list")
    Result list(Journal query, int current, int pageSize) {
        Pageable pageable = PageRequest.of(current - 1, pageSize);
        Example<Journal> example = Example.of(query, query.buildMatcher());
        Page<Journal> pageableList = journalRepository.findAll(example, pageable);
        return Result.OK(pageableList.getContent(), pageableList.getNumber(), pageableList.getTotalPages());
    }

    @PostMapping("/add")
    public Result add(Journal journal) {
        journalRepository.save(journal);
        return Result.OK();
    }

    @GetMapping(value = "/remove")
    Result remove(@RequestParam(name = "ids") List<String> ids) {
        journalRepository.deleteAllById(ids);
        return Result.OK();
    }
}
