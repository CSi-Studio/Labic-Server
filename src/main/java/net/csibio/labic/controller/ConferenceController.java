package net.csibio.labic.controller;

import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.Asset;
import net.csibio.labic.domain.db.Conference;
import net.csibio.labic.repository.AssetRepository;
import net.csibio.labic.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conference")
public class ConferenceController {

    @Autowired
    ConferenceRepository conferenceRepository;

    @RequestMapping(value = "/list")
    Result list(Conference query, int current, int pageSize) {
        Pageable pageable = PageRequest.of(current - 1, pageSize);
        Example<Conference> example = Example.of(query, query.buildMatcher());
        Page<Conference> pageableList = conferenceRepository.findAll(example, pageable);
        return Result.OK(pageableList.getContent(), pageableList.getNumber(), pageableList.getTotalPages());
    }

    @PostMapping("/add")
    public Result add(Conference conference) {
        conferenceRepository.save(conference);
        return Result.OK();
    }

    @GetMapping(value = "/remove")
    Result remove(@RequestParam(name = "ids") List<String> ids) {
        conferenceRepository.deleteAllById(ids);
        return Result.OK();
    }
}
