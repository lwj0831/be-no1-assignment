package org.kakaoTechCampus.calculatorProject;

import java.util.ArrayList;
import java.util.List;

public class OperationResults<T extends Number> {
    private final List<T> results;

    public OperationResults() {
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
