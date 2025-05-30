package org.kakaoTechCampus.calculatorProject.level2;

import java.util.ArrayList;
import java.util.List;

public class Lv2_OperationResults {
    private final List<Integer> results;

    public Lv2_OperationResults() {
        this.results = new ArrayList<>();
    }

    public void save(int result) {
        results.add(result);
    }
    public void delete(){
        results.remove(0);
    }

    public List<Integer> getResults(){
        return new ArrayList<>(results);
    }

    public int getSize(){
        return results.size();
    }
}
