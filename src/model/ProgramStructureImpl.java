package model;


import model.interfaces.Exemption;
import model.interfaces.ProgramStructure;

import java.util.ArrayList;

public class ProgramStructureImpl implements ProgramStructure {

    public ProgramStructureImpl() { //constructor

    }

    private ArrayList< Exemption> exemptions = new ArrayList<Exemption>();


        ArrayList< Exemption > list = exemptions;


public void addExemption(Exemption e)
 {
    exemptions.add(e);

    }

    public void deleteExemption(Exemption e)
    {
        exemptions.remove(e);

    }


    @Override
public String toString() {
        return null;
    }
}

