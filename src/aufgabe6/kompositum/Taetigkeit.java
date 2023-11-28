package kompositum;

public interface Taetigkeit {

    double getTime();

    void add(Taetigkeit tk);

    void remove(Taetigkeit tk);

    int getAnzahl();
}
