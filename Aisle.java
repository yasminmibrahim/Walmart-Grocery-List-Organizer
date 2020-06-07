public enum Aisle {
    
    A1(1, new String[]{"Fruits", "Vegetables"}), 
    A2(2, new String[]{"Icecream"}),
    A3(3, new String[]{"Dinners"}),
    A4(4, new String[]{"Frozen Breakfast", "Frozen Pizza"}),
    A5(5, new String[]{"Entrees", "Chicken"}),
    A6(6, new String[]{"Juice Concentrate", "Snacks"}),
    A7(7, new String[]{"Candy", "Frozen Vegetable"}),
    A8(8, new String[]{"Salad Dressings", "Peanut Butter"}),
    A9(9, new String[]{"Canned Meat", "Bulk Size"}),
    A10(10, new String[]{"Canned Vegetables", "Canned Fruit"}),
    A11(11, new String[]{"Rice", "International Foods"}),
    A12(12, new String[]{"Flour", "Sugar"}),
    A13(13, new String[]{"Cake Mixes", "Soup & Pasta"}),
    A14(14, new String[]{"Cereal", "Toaster Pastries"}),
    A15(15, new String[]{"Syrup", "Gelatin"}),
    A16(16, new String[]{"Soft Drinks", "Water"}),
    A17(17, new String[]{"Coffee", "Tea"}),
    A18(18, new String[]{"Wine", "Cold Beer", "Mixers"}),
    A19(19, new String[]{"Chips"}),
    A20(20, new String[]{"Bread"}),
    A21(21, new String[]{"Eggs", "Milk"});
     
    private final int num;
    private final String[] categories;
    
    private Aisle(int num, String[] categories) {
        this.num = num;
        this.categories = categories;
    }
    
    public String[] getCategories() {
        return this.categories;
    }
        
        
}