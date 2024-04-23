package services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@Component   // initialise an object of this class, in the start of the program
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProductById(Long id) {
//        throw new RuntimeException("Something went Wrong in Services");
//        int []arr = new int[10];
//        int a = arr[11];
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        if( fakeStoreProductDto == null ){
            throw new ProductNotFoundException(id, "Please pass a Valid ProductId [ Product Not Found Exception / Custom Exception ]");
        }

        Product product = convertFakeStoreDtosToProduct(fakeStoreProductDto);
        return product;
    }

    public List<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
            products.add(convertFakeStoreDtosToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private Product convertFakeStoreDtosToProduct( FakeStoreProductDto fakeStoreProductDto ){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}

