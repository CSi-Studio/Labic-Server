package net.csibio.labic.controller;

import net.csibio.labic.domain.Result;
import net.csibio.labic.domain.db.Publication;
import net.csibio.labic.domain.db.User;
import net.csibio.labic.domain.query.UserQuery;
import net.csibio.labic.repository.PublicationRepository;
import net.csibio.labic.repository.UserRepository;
import net.csibio.labic.utils.PublicationUtil;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXObject;
import org.jbibtex.BibTeXParser;
import org.jbibtex.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    @Autowired
    PublicationRepository publicationRepository;

    @RequestMapping(value = "/list")
    Result list(UserQuery query) {
        Pageable pageable = PageRequest.of(query.getCurrent() - 1, query.getPageSize());
        Page<Publication> pageableList = publicationRepository.findAll(pageable);
        return Result.OK(pageableList.getContent(), pageableList.getNumber(), pageableList.getTotalPages());
    }

    @PostMapping("/addFromBib")
    public Result addFromBib(@RequestParam(value = "content", required = false) String content) throws ParseException {
        List<Publication> pubList= PublicationUtil.parse(content);
        publicationRepository.saveAll(pubList);
        return Result.OK();
    }
}
