package net.csibio.labic.constants;

/**
 * @author guyao
 * @version 1.0
 * @description: HMDB xml 文件的属性枚举
 * @date 2023/11/24 9:27
 */
public interface HmdbXmlConst {

    String METABOLITE = "metabolite";
    String VERSION = "version";
    String CREATION_DATE = "creation_date";
    String UPDATE_DATE = "update_date";
    String ACCESSION = "accession";
    String STATUS = "status";
    String SECONDARY_ACCESSIONS = "secondary_accessions";
    String NAME = "name";
    String DESCRIPTION = "description";
    String SYNONYMS = "synonyms";
    String SYNONYM = "synonym";
    String CHEMICAL_FORMULA = "chemical_formula";
    String AVERAGE_MOLECULAR_WEIGHT = "average_molecular_weight";
    String MONISOTOPIC_MOLECULAR_WEIGHT = "monisotopic_molecular_weight";
    String IUPAC_NAME = "iupac_name";
    String TRADITIONAL_IUPAC = "traditional_iupac";
    String CAS_REGISTRY_NUMBER = "cas_registry_number";
    String SMILES = "smiles";
    String INCHI = "inchi";
    String INCHIKEY = "inchikey";
    String TAXONOMY = "taxonomy";
    String KINGDOM = "kingdom";
    String ONTOLOGY = "ontology";
    String STATE = "state";
    String DISEASES = "diseases";
    String DISEASE = "disease";
    String OMIM_ID = "omim_id";
    String REFERENCES = "references";
    String REFERENCE = "reference";
    String REFERENCE_TEXT = "reference_text";
    String PUBMED_ID = "pubmed_id";
    String CHEMSPIDER_ID = "chemspider_id";
    String DRUGBANK_ID = "drugbank_id";
    String FOODB_ID = "foodb_id";
    String PUBCHEM_COMPOUND_ID = "pubchem_compound_id";
    String PDB_ID = "pdb_id";
    String CHEBI_ID = "chebi_id";
    String PHENOL_EXPLORER_COMPOUND_ID = "phenol_explorer_compound_id";
    String KNAPSACK_ID = "knapsack_id";
    String KEGG_ID = "kegg_id";
    String BIOCYC_ID = "biocyc_id";
    String BIGG_ID = "bigg_id";
    String WIKIPEDIA_ID = "wikipedia_id";
    String METLIN_ID = "metlin_id";
    String VMH_ID = "vmh_id";
    String FBONTO_ID = "fbonto_id";
    String SYNTHESIS_REFERENCE = "synthesis_reference";
    String GENERAL_REFERENCES = "general_references";


    String EXPERIMENTAL_PROPERTIES = "experimental_properties";

    String PREDICTED_PROPERTIES = "predicted_properties";

    String SPECTRA = "spectra";

    String BIOLOGICAL_PROPERTIES = "biological_properties";
    String NORMAL_CONCENTRATIONS = "normal_concentrations";
    String ABNORMAL_CONCENTRATIONS = "abnormal_concentrations";
    String PROTEIN_ASSOCIATIONS = "protein_associations";


    // 光谱图 xml 枚举标签
    String MS_MS = "ms-ms";
    String ID = "id";
    String NOTES = "notes";
    String SAMPLE_CONCENTRATION = "sample-concentration";
    String SOLVENT = "solvent";
    String SAMPLE_MASS = "sample-mass";
    String SAMPLE_ASSESSMENT = "sample-assessment";
    String SPECTRA_ASSESSMENT = "spectra-assessment";
    String SAMPLE_SOURCE = "sample-source";
    String COLLECTION_DATE = "collection-date";
    String INSTRUMENT_TYPE = "instrument-type";
    String PEAK_COUNTER = "peak-counter";
    String CREATED_AT = "created-at";
    String UPDATED_AT = "updated-at";
    String MONO_MASS = "mono-mass";
    String ENERGY_FIELD = "energy-field";
    String COLLISION_ENERGY_LEVEL = "collision-energy-level";
    String COLLISION_ENERGY_VOLTAGE = "collision-energy-voltage";
    String IONIZATION_MODE = "ionization-mode";
    String SAMPLE_CON = "sample-concentration-units";
    String SAMPLE_MASS_UN = "sample-mass-units";
    String PREDICTED = "predicted";
    String STRUCTURE_ID = "structure-id";
    String SPLASH_KEY = "splash-key";
    String DATABASE_ID = "database-id";
    String MS_MS_PEAKS = "ms-ms-peaks";
    String MS_MS_PEAK = "ms-ms-peak";
    String MS_MS_ID = "ms-ms-id";
    String MASS_CHARGE = "mass-charge";
    String INTENSITY = "intensity";
    String MOLECULE_ID = "molecule-id";


    static String getMS_MS_Website(String id) {
        return getWebsite(MS_MS, id);
    }

    static String getWebsite(String tag, String id) {
        return "https://hmdb.ca/spectra/" + tag.replaceAll(SymbolConst.DELIMITER, SymbolConst.UNDERLINE) + "/" + id;
    }

    static String getPeaksName(String tag) {
        return tag + SymbolConst.DELIMITER + "peaks";
    }

    static String getPeakName(String tag) {
        return tag + SymbolConst.DELIMITER + "peak";
    }


}
