package net.csibio.labic.controller;

import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.Publication;
import net.csibio.labic.domain.db.User;
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
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    PublicationRepository publicationRepository;

    @RequestMapping(value = "/list")
    Result list(Publication query, int current, int pageSize) {
        Pageable pageable = PageRequest.of(current - 1, pageSize);
        Example<Publication> example = Example.of(query, query.buildMatcher());
        Page<Publication> pageableList = publicationRepository.findAll(example, pageable);
        return Result.OK(pageableList.getContent(), pageableList.getNumber(), pageableList.getTotalPages());
    }

    @PostMapping("/addFromBib")
    public Result addFromBib(@RequestParam(value = "content", required = false) String content) throws ParseException {
        List<Publication> pubList= PublicationUtil.parse(content);
        publicationRepository.saveAll(pubList);
        return Result.OK();
    }

    @GetMapping(value = "/remove")
    Result remove(@RequestParam(name = "ids") List<String> ids) {
        publicationRepository.deleteAllById(ids);
        return Result.OK();
    }
}
