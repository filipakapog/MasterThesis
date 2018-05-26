package cemadoare.service;

public interface LoginResponsible {
    boolean tryLoginAdmin(String username, String password);
    boolean tryLoginUser(String username, String password);
}
