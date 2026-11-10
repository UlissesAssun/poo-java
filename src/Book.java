public class Book implements Publication {
    // Encapsulated private attributes
    private String title;
    private String author;
    private int totalPages;
    private int currentPage;
    private boolean open;
    private Person reader;

    // Constructor: initializes open as false and currentPage as 0
    public Book(String title, String author, int totalPages, Person reader) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.reader = reader;
        this.open = false;
        this.currentPage = 0;
    }

    // Book details method (Slide 35 format)
    public String details() {
        return "Livro: " + "Título= " + this.title + "\n, Autor= "
                + this.author + "\n, Total de Paginas= " + this.totalPages
                + "\n, Página Atual= " + this.currentPage + "\n, Aberto?= "
                + this.open + "\n, Leitor=" + (this.reader != null ? this.reader.getName() : "")
                + " Idade:" + (this.reader != null ? this.reader.getAge() : 0)
                + " Sexo:" + (this.reader != null ? this.reader.getGender() : "");
    }

    // Methods from Publication interface
    @Override
    public void open() {
        this.setOpen(true);
    }

    @Override
    public void close() {
        this.setOpen(false);
    }

    @Override
    public void browse(int page) {
        if (page > this.totalPages) {
            this.setCurrentPage(0); // Resets to 0 if out of bounds (Slide 37)
        } else if (page < 0) {
            this.setCurrentPage(0);
        } else {
            this.setCurrentPage(page);
        }
    }

    @Override
    public void advancePage() {
        if (this.getCurrentPage() < this.totalPages) {
            this.setCurrentPage(this.getCurrentPage() + 1);
        }
    }

    @Override
    public void backPage() {
        if (this.getCurrentPage() > 0) {
            this.setCurrentPage(this.getCurrentPage() - 1);
        }
    }

    // Getters and Setters
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Person getReader() {
        return this.reader;
    }

    public void setReader(Person reader) {
        this.reader = reader;
    }

    // Portuguese alias methods for full academic compatibility
    public String detalhes() { return details(); }
    public void abrir() { open(); }
    public void fechar() { close(); }
    public void folhear(int p) { browse(p); }
    public void avancarPag() { advancePage(); }
    public void voltarPag() { backPage(); }
    public String getTitulo() { return getTitle(); }
    public void setTitulo(String t) { setTitle(t); }
    public String getAutor() { return getAuthor(); }
    public void setAutor(String a) { setAuthor(a); }
    public int getTotPaginas() { return getTotalPages(); }
    public void setTotPaginas(int tp) { setTotalPages(tp); }
    public int getPagAtual() { return getCurrentPage(); }
    public void setPagAtual(int pa) { setCurrentPage(pa); }
    public boolean isAberto() { return isOpen(); }
    public boolean getAberto() { return isOpen(); }
    public void setAberto(boolean ab) { setOpen(ab); }
    public Person getLeitor() { return getReader(); }
    public void setLeitor(Person l) { setReader(l); }
}
