package cambridge.uz.omborxona.service;

import cambridge.uz.omborxona.entity.Category;
import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.CategoryDto;
import cambridge.uz.omborxona.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public ApiResponse addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(category.getName());
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (optionalParentCategory.isEmpty()) {
                new ApiResponse("Bunday ota kategoriya mavjud emas", false);
            }
            category.setParentCategory(optionalParentCategory.get());
        }
        Category save = categoryRepository.save(category);
        return new ApiResponse("Muvaffaqiyatli saqlandi", true);
    }

    public ApiResponse deleteCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setActive(false);
            return new ApiResponse("o'chirildi", true);
        }
        return new ApiResponse("Bunday categoriya topilmadi",false,null);
    }

    public ApiResponse getCategotById(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = categoryRepository.getById(id);
            return new ApiResponse("mana ol", true,category);
        }
        return new ApiResponse("Bunday categoriya topilmadi",false,null);
    }
}
