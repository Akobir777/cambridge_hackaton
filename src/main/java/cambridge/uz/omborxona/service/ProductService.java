package cambridge.uz.omborxona.service;


import cambridge.uz.omborxona.entity.*;
import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.ProductDto;
import cambridge.uz.omborxona.repository.AttachmentRepository;
import cambridge.uz.omborxona.repository.CategoryRepository;
import cambridge.uz.omborxona.repository.MeasurementRepository;
import cambridge.uz.omborxona.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    MeasurementRepository measurementRepository;

    public ApiResponse addProduct(ProductDto productDto) {
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (existsByNameAndCategoryId) {
            return new ApiResponse("Bunday maxsulot ushbu kategoriyada mavjud", false);
        }
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new ApiResponse("Bunday kategoriya mavjud emas", false);
        }
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalCategory.isPresent()){
            return new ApiResponse("Bunday rasm mavjud emas",false);
        }
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalCategory.isPresent()){
            return new ApiResponse("Bunday ulchov birligi mavjud emas",false);
        }
        Product product = new Product();
        product.setName(productDto.getName());
        UUID uuid = UUID.randomUUID();
        product.setCode(String.valueOf(uuid));//todo generatsiya qilish kk
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        Product save = productRepository.save(product);
        return new ApiResponse("Maxsulot saqlandi",true,save);
    }

    public ApiResponse getOne(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty())
            return new ApiResponse("not found", false);
        return new ApiResponse("mana", true, byId.get());
    }

    public ApiResponse getAll() {
        List<Product> products = productRepository.findAll();
        return new ApiResponse("mana", true, products);
    }

    public ApiResponse edit(Integer id, ProductDto dto) {
        boolean existsByNameAndCategoryId = productRepository.existsByNameAndCategoryId(productDto.getName(), productDto.getCategoryId());
        if (existsByNameAndCategoryId) {
            return new ApiResponse("Bunday maxsulot ushbu kategoriyada mavjud", false);
        }
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new ApiResponse("Bunday kategoriya mavjud emas", false);
        }
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(productDto.getPhotoId());
        if (!optionalCategory.isPresent()){
            return new ApiResponse("Bunday rasm mavjud emas",false);
        }
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(productDto.getMeasurementId());
        if (!optionalCategory.isPresent()){
            return new ApiResponse("Bunday ulchov birligi mavjud emas",false);
        }
        Product product = new Product();
        product.setName(productDto.getName());
        UUID uuid = UUID.randomUUID();
        product.setCode(String.valueOf(uuid));//todo generatsiya qilish kk
        product.setCategory(optionalCategory.get());
        product.setPhoto(optionalAttachment.get());
        product.setMeasurement(optionalMeasurement.get());
        Product save = productRepository.save(product);
        return new ApiResponse("Maxsulot saqlandi",true,save);
    }
}
