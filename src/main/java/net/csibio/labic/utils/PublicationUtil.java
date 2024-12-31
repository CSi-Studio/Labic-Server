package net.csibio.labic.utils;

import net.csibio.labic.domain.db.Publication;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.BibTeXParser;
import org.jbibtex.ParseException;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PublicationUtil {

    public static List<Publication> parse(String content) throws ParseException {
        BibTeXParser parser = new BibTeXParser();
        Collection<BibTeXEntry> bibList = parser.parse(new StringReader(content)).getEntries().values();
        List<Publication> publicationList = new ArrayList<Publication>();
        bibList.forEach(bib -> {
            Publication publication = new Publication();
            publication.setType(bib.getType().getValue());
            publication.setKey(bib.getKey().getValue());
            publication.setAuthor(bib.getField(BibTeXEntry.KEY_AUTHOR).toString())
                    .setTitle(bib.getField(BibTeXEntry.KEY_TITLE).toString())
                    .setYear(bib.getField(BibTeXEntry.KEY_YEAR).toString())
                    .setJournal(bib.getField(BibTeXEntry.KEY_JOURNAL).toString())
                    .setVolume(bib.getField(BibTeXEntry.KEY_VOLUME).toString())
                    .setNumber(bib.getField(BibTeXEntry.KEY_NUMBER).toString())
                    .setPages(bib.getField(BibTeXEntry.KEY_PAGES).toString())
                    .setMonth(bib.getField(BibTeXEntry.KEY_MONTH).toString())
                    .setNote(bib.getField(BibTeXEntry.KEY_NOTE).toString())
                    .setBooktitle(bib.getField(BibTeXEntry.KEY_BOOKTITLE).toString())
                    .setPublisher(bib.getField(BibTeXEntry.KEY_PUBLISHER).toString())
                    .setAddress(bib.getField(BibTeXEntry.KEY_ADDRESS).toString())
                    .setDoi(bib.getField(BibTeXEntry.KEY_DOI).toString())
                    .setUrl(bib.getField(BibTeXEntry.KEY_URL).toString())
                    .setAnnote(bib.getField(BibTeXEntry.KEY_ANNOTE).toString())
                    .setChapter(bib.getField(BibTeXEntry.KEY_CHAPTER).toString())
                    .setCrossref(bib.getField(BibTeXEntry.KEY_CROSSREF).toString())
                    .setSeries(bib.getField(BibTeXEntry.KEY_SERIES).toString())
                    .setSchool(bib.getField(BibTeXEntry.KEY_SCHOOL).toString())
                    .setInstitution(bib.getField(BibTeXEntry.KEY_INSTITUTION).toString())
                    .setHowPublished(bib.getField(BibTeXEntry.KEY_HOWPUBLISHED).toString())
                    .setOrginazation(bib.getField(BibTeXEntry.KEY_ORGANIZATION).toString())
                    .setEprint(bib.getField(BibTeXEntry.KEY_EPRINT).toString())
                    .setEdition(bib.getField(BibTeXEntry.KEY_EDITION).toString())
                    .setEditor(bib.getField(BibTeXEntry.KEY_EDITOR).toString());
            publicationList.add(publication);
        });
        return publicationList;
    }
}
