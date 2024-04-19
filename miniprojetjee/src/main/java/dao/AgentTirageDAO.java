package dao;

import model.AgentTirage;

public interface AgentTirageDAO {
    AgentTirage findByUsername(String username);
}
