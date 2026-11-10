public interface Publication {
    public abstract void open();
    public abstract void close();
    public abstract void browse(int page);
    public abstract void advancePage();
    public abstract void backPage();

    // Portuguese alias methods for full academic compatibility
    default void abrir() { open(); }
    default void fechar() { close(); }
    default void folhear(int p) { browse(p); }
    default void avancarPag() { advancePage(); }
    default void voltarPag() { backPage(); }
}
