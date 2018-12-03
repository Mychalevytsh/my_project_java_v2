package store;

import java.util.Objects;

public class Good {
    //поля класу
    private int id;                        //1
    private String name;                   //2
    private String category;               //3
    private String productionDate;         //4
    private String expiryDate;             //5
    private int quantity;                  //6
    private double price;                  //7
    private String provider;               //8
    private String providerPhone;          //9
    private String receiveDate;            //10
    private int store;                     //11
    private String description;            //12
    private String extraInfo;              //13
    private static int count = 1;

    //Конструктор
    public Good(String name, String category, String productionDate, String expiryDate, int quantity, double price,
                String provider, String providerPhone, String receiveDate, int store, String description, String extraInfo) {
        this.id = count++;
        this.name = name;
        this.category = category;
        this.productionDate = productionDate;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.price = price;
        this.provider = provider;
        this.providerPhone = providerPhone;
        this.receiveDate = receiveDate;
        this.store = store;
        this.description = description;
        this.extraInfo = extraInfo;
    }

    //get id
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderPhone() {
        return providerPhone;
    }

    public void setProviderPhone(String providerPhone) {
        this.providerPhone = providerPhone;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {  this.description = description;}


    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    //set id
    public void setId(int id) {
        this.id = count++;
    }



    @Override
    public String toString() {
        return "Good Info:" +
                "\nid:                         " + id +
                "\nНазва товару:               " + this.name +
                "\nКатегорія:                  " + this.category +
                "\nДата виготовлення           " + this.productionDate +
                "\nТермін придатності          " + this.expiryDate +
                "\nКількість:                  " + this.quantity +
                "\nЦіна:                       " + this.price +
                "\nПостачальник:               " + this.provider+
                "\nномер телефону постачальника" + this.providerPhone +
                "\nДата поставки               " + this.receiveDate +
                "\nНомер складу                " + this.store +
                "\nКороткий опис               " + this.description +
                "\nПримітки                    " + this.extraInfo;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return (this.getId() == good.getId()) &&
                Objects.equals(this.getName(), good.getName())&&
                    Objects.equals(this.getCategory(), good.getCategory())&&
                        Objects.equals(this.getDescription(), good.getDescription())&&
                            Objects.equals(this.getProductionDate(), good.getProductionDate())&&
                                 Objects.equals(this.getProvider(), good.getProvider()) &&
                                    Objects.equals(this.getReceiveDate(), good.getReceiveDate()) &&
                                         Objects.equals(this.getStore(), good.getStore());

   }

}
