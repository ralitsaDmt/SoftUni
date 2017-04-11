package Problem_10_Mood3.contracts;

public interface IGameObject {

    String getUserName();

    <T> T getPassword();

    <V> V getSpecialPoins();

    int getLevel();
}
