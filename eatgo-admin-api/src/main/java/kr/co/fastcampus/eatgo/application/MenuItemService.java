package kr.co.fastcampus.eatgo.application;


import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuItemService {
    private static MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public void bulkUpdate(Long restaurantId, List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            Update(restaurantId,menuItem);
        }
    }
    public void Update(Long restaurantId,MenuItem menuItem){
        if(menuItem.isDestroy()){
            menuItemRepository.deleteById((menuItem.getId()));
            return;
        }
        menuItem.setRestaurantId(restaurantId);
        menuItemRepository.save(menuItem);
    }

    public static List<MenuItem> getMenuItems(Long restaurantId) {
        return menuItemRepository.findAllByRestaurantId(restaurantId);
    }
}
