package com.yanjinbin.springboot.hellomodule;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Silver Bullet
 * @since 三月-03
 */
@Component
public class UserRepository {
    private User user;
    private Set<User> set =new HashSet<>();

    public UserRepository() {
        set.add(new User(1, 11, "a"));
        set.add(new User(2, 12, "b"));
        set.add(new User(3, 13, "c"));
    }

    public void detele(Integer id) {
        Iterator<User> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                set.remove(iterator.next());
            }
        }
    }

    public void add(User user) {
        set.add(user);
    }

   public void update(User user) {
        Iterator<User> iterator = set.iterator();
        while (iterator.hasNext()) {
            User next = iterator.next();
            if (next.getId().equals(user.getId())) {
                next = user;
                break;
            }
        }
    }

    public User get(Integer id) {
        Iterator<User> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                return iterator.next();
            }
        }
        return null;
    }
}
