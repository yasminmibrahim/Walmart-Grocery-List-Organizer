public enum Aisle {
    
    A1(new String[]{"Icecream"}), A2(new String[]{"Frozen Dinner"}), A3(new String[]{"Pasta", "Flour"});
    
    private final String[] categories;
    
    private Aisle(String[] categories) {
        this.categories = categories;
    }
    
    public String[] getCategories() {
        return this.categories;
    }
        
        
}