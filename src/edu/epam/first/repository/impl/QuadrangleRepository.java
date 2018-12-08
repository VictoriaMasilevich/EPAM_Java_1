package edu.epam.first.repository.impl;

import edu.epam.first.entity.Quadrangle;
import edu.epam.first.repository.Repository;

import java.util.ArrayList;

public class QuadrangleRepository implements Repository<Quadrangle> {

    private static QuadrangleRepository instance = new QuadrangleRepository();

    private ArrayList<Quadrangle> quadrangles = new ArrayList<>();

    private QuadrangleRepository() {
    }

    public static QuadrangleRepository getInstance() {
        return instance;
    }

    @Override
    public void add(Quadrangle quadrangle) {
        quadrangles.add(quadrangle);
    }

    @Override
    public void remove(Quadrangle quadrangle) {
        quadrangles.remove(quadrangle);
    }

    public void removeAll() {
        quadrangles.clear();
    }
}
