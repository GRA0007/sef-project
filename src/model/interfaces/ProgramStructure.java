package model.interfaces;

public interface ProgramStructure {
    /*
     * Variables
     *
     * List<Exemption> exemptions
     */
    void addExemption(Exemption exemption);

    void deleteExemption(Exemption exemption);

    Exception[] getExemptions();
}
