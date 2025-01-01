package net.csibio.labic.utils;

import net.csibio.labic.domain.db.Publication;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXParser;
import org.jbibtex.ParseException;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.jbibtex.BibTeXEntry.KEY_AUTHOR;
import static org.jbibtex.BibTeXEntry.KEY_BOOKTITLE;

public class PublicationUtil {

    public static List<Publication> parse(String content) throws ParseException {
        BibTeXParser parser = new BibTeXParser();
        Collection<BibTeXEntry> bibList = parser.parse(new StringReader(content)).getEntries().values();
        List<Publication> publicationList = new ArrayList<Publication>();
        bibList.forEach(bib -> {
            Publication publication = new Publication();
            publication.setType(bib.getType().getValue());
            publication.setKey(bib.getKey().getValue());
            bib.getFields().forEach((key, value) -> {
                switch (key.toString().toLowerCase()) {
                    case "author":
                        publication.setAuthor(value.toUserString());
                        break;
                    case "booktitle":
                        publication.setBooktitle(value.toUserString());
                        break;
                    case "chapter":
                        publication.setChapter(value.toUserString());
                        break;
                    case "crossref":
                        publication.setCrossref(value.toUserString());
                        break;
                    case "doi":
                        publication.setDoi(value.toUserString());
                        break;
                    case "edition":
                        publication.setEdition(value.toUserString());
                        break;
                    case "editor":
                        publication.setEditor(value.toUserString());
                        break;
                    case "eprint":
                        publication.setEprint(value.toUserString());
                        break;
                    case "howpublished":
                        publication.setHowPublished(value.toUserString());
                        break;
                    case "institution":
                        publication.setInstitution(value.toUserString());
                        break;
                    case "journal":
                        publication.setJournal(value.toUserString());
                        break;
                    case "month":
                        publication.setMonth(value.toUserString());
                        break;
                    case "note":
                        publication.setNote(value.toUserString());
                        break;
                    case "number":
                        publication.setNumber(value.toUserString());
                        break;
                    case "organization":
                        publication.setOrganization(value.toUserString());
                        break;
                    case "pages":
                        publication.setPages(value.toUserString());
                        break;
                    case "publisher":
                        publication.setPublisher(value.toUserString());
                        break;
                    case "school":
                        publication.setSchool(value.toUserString());
                        break;
                    case "series":
                        publication.setSeries(value.toUserString());
                        break;
                    case "title":
                        publication.setTitle(value.toUserString());
                        break;
                    case "url":
                        publication.setUrl(value.toUserString());
                        break;
                    case "volume":
                        publication.setVolume(value.toUserString());
                        break;
                    case "year":
                        publication.setYear(value.toUserString());
                        break;
                    case "abstract":
                        publication.setAbstractText(value.toUserString());
                        break;
                    case "issn":
                        publication.setIssn(value.toUserString());
                        break;
                    case "language":
                        publication.setLanguage(value.toUserString());
                        break;
                    default:
                        System.out.println("Unexpected value: " + key);
                }
            });
            publicationList.add(publication);
        });
        return publicationList;
    }
}
