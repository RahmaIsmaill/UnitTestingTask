import com.adminPanel.app.entity.Product;
import com.adminPanel.app.entity.ProductDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductApiTest {

    private RestTemplate restTemplate = new RestTemplate();
    String URL = "http://localhost:8082/Amazon_El8alabah/api/v1";

    @Test
    public void testGetAllProducts() {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(URL + "/products", String.class);
            System.out.println("Status: " + response.getStatusCode());
            System.out.println("Body: " + response.getBody());
           assertEquals(HttpStatus.OK, response.getStatusCode());

        } catch (Exception e) {
            System.err.println("Error while calling API: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testGetProductById() {
        try {
            ResponseEntity<Product> response = restTemplate.getForEntity(URL + "/product/1", Product.class);
            System.out.println("Status: " + response.getStatusCode());
            System.out.println("Body: " + response.getBody());
            assertEquals(HttpStatus.OK, response.getStatusCode());
        } catch (Exception e) {
            System.err.println("Error while calling API: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testGetProductDetailsByName() {
        try {
            ResponseEntity<ProductDetails> response = restTemplate.getForEntity(
                    URL + "/productDetails/name/eggs", ProductDetails.class
            );

            System.out.println("Status: " + response.getStatusCode());
            System.out.println("Body: " + response.getBody());
            assertEquals(HttpStatus.OK, response.getStatusCode());
        } catch (Exception e) {
            System.err.println("Error while calling API: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testInsertProduct() {
       try{
        ProductDetails productDetails = new ProductDetails();
        productDetails.setName("tea");
        productDetails.setPrice(10.0);
        productDetails.setAvailable(1);
        productDetails.setManufacturer("egy");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date expirationDate = formatter.parse("2026-12-31");
        productDetails.setExpiration_date(expirationDate);

     ResponseEntity<ProductDetails> response =   restTemplate.postForEntity(URL + "/productDetails", productDetails, ProductDetails.class);
           System.out.println("Status: " + response.getStatusCode());
           System.out.println("Body: " + response.getBody());
           assertEquals(HttpStatus.OK, response.getStatusCode());


    } catch (Exception e) {
        System.err.println("Error while calling API: " + e.getMessage());
        e.printStackTrace();
    }
    }

    @Test
    public void testUpdateProduct() {
        try {


            ResponseEntity<ProductDetails> responseProduct = restTemplate.getForEntity(URL + "/productDetails/24", ProductDetails.class);
            ProductDetails productDetails = responseProduct.getBody();


            productDetails.setName("tea");
            productDetails.setPrice(10.0);
            productDetails.setAvailable(1);
            productDetails.setManufacturer("egy");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date expirationDate = formatter.parse("2026-12-31");
            productDetails.setExpiration_date(expirationDate);

            restTemplate.put(URL + "/productDetails/24", productDetails, ProductDetails.class);
            System.out.println("Product Updated Successfully");

        } catch (Exception e) {
            System.err.println("Error while calling API: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteProduct() {
        try {
            restTemplate.delete(URL + "/productDetails/24");
            System.out.println("Product Deleted Successfully");
        } catch (Exception e) {
            System.err.println("Error while calling API: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
