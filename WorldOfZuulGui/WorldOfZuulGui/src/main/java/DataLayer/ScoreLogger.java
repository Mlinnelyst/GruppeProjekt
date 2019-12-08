package DataLayer;

import java.util.List;

public interface ScoreLogger {
    public void save(List<String> data);
    public List<String> load();
}
