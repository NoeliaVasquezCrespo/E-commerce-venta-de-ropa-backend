package ucb.edu.bo.sis.ventaropa.service;

import ucb.edu.bo.sis.ventaropa.model.Color;

import java.util.List;

public interface ColourService {
    List<Color> findAll();
    Color createColour(Color color);
    Color updateColour(Color color, Integer colorId);
    void deleteColour(Integer id);
}
