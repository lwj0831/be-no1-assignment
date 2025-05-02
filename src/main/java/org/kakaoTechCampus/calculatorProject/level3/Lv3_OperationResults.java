package org.kakaoTechCampus.calculatorProject.level3;

import java.util.ArrayList;
import java.util.List;

public class Lv3_OperationResults<T extends Number> {
    private final List<T> results;

    public Lv3_OperationResults() {
        this.results = new ArrayList<>();
    }

    public void save(T result) {
        results.add(result);
    }
    public void delete(){
        results.remove(0);
    }

    public List<T> getResults(){
        return new ArrayList<>(results);
    }

    public int getSize(){
        return results.size();
    }
}
