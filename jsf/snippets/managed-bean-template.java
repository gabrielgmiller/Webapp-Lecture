package YOUR.PACKAGE.HERE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ViewScoped; // or SessionScoped
import jakarta.inject.Named;

@Named
@ViewScoped
public class BeanTemplate implements Serializable {
    private static final long serialVersionUID = 1L;

    // ====== Form fields ======
    private String searchText;
    private boolean includeTitle = true;
    private boolean includeAuthor = false;

    // ====== Data ======
    private List<Object> results;
    private Object selected;

    @PostConstruct
    public void init() {
        results = new ArrayList<>();
    }

    // ====== Actions ======
    public void search() {
        // TODO: call service, fill results
        // if nothing found -> add message (see messages snippet)
    }

    public String showDetails(Object item) {
        this.selected = item;
        return "detailsView?faces-redirect=true";
    }

    public String backToList() {
        return "products?faces-redirect=true";
    }

    // ====== Getters/Setters ======
    public String getSearchText() { return searchText; }
    public void setSearchText(String searchText) { this.searchText = searchText; }

    public boolean isIncludeTitle() { return includeTitle; }
    public void setIncludeTitle(boolean includeTitle) { this.includeTitle = includeTitle; }

    public boolean isIncludeAuthor() { return includeAuthor; }
    public void setIncludeAuthor(boolean includeAuthor) { this.includeAuthor = includeAuthor; }

    public List<Object> getResults() { return results; }
    public void setResults(List<Object> results) { this.results = results; }

    public Object getSelected() { return selected; }
    public void setSelected(Object selected) { this.selected = selected; }
}
