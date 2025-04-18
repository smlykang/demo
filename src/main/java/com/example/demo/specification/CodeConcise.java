package com.example.demo.specification;


import com.example.demo.entity.Address;
import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CodeConcise {

    /*
      代码简洁性
          消除冗余代码，提升逻辑表达力，减少维护成本。
          Stream API 和 Optional
      消除重复代码
        工具类封装：将重复逻辑提取到 StringUtils、DateUtils 等工具类。
        模板方法模式：抽象公共流程（如订单创建流程中的校验、扣库存、生成日志）。
     */

    /**
     * Stream API：简化集合操作，避免嵌套循环。
     */
    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User("张三", new Address("北京")));
        users.add(new User("李四", new Address("上海")));
        users.add(new User("王五", new Address("上海")));
        users.add(new User("马六", new Address("北京")));
        users.add(new User("马六", new Address("上海")));
    }

    // 循环
    public static void foreach() {
        // 传统循环
        List<String> nameList = new ArrayList<>();
        for (User user : users) {
            nameList.add(user.getName());
        }
        System.out.println("for 用户城市列表" + nameList);

        // Stream API
        List<String> names = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println("Stream API用户城市列表" + names);
    }

    // 过滤
    public static void filter() {
        List<String> names = users.stream()
                .filter(user -> {
                    Address address = user.getAddress();
                    return address != null && "北京".equals(address.getCity());
                })
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println("北京用户:" + names);
    }

    // 去重
    public static void distinct() {
        List<String> names = users.stream()
                .map(User::getName)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("去重获取用户名:" + names);
    }

    // 集合转 Map
    public static void map() {

        Map<String, List<User>> groupMap = users.stream()
                .collect(Collectors.groupingBy(
                        User::getName,
                        Collectors.toList()
                ));
        System.out.println("分组后的map:" + groupMap);

        Map<String, User> nameUserMap = users.stream()
                .collect(Collectors.toMap(
                        User::getName,
                        user -> user,
                        (oldVal, newVal) -> newVal
                ));
        System.out.println("名字-用户:" + nameUserMap);

        Map<String, String> nameCityMap = users.stream()
                .collect(Collectors.toMap(
                        User::getName,
                        user -> Optional.ofNullable(user.getAddress())
                                .map(Address::getCity)
                                .orElse("未知地区"),
                        (oldVal, newVal) -> oldVal // 解决重复 key 冲突
                ));
        System.out.println("名字-城市:" + nameCityMap);

    }

    // 分组统计
    public static void group() {
        Map<String, List<String>> cityCounts = users.stream()
                .collect(Collectors.groupingBy(
                        user -> user.getAddress().getCity(),
                        Collectors.mapping(                   // 对分组后的用户进行映射
                                User::getName,                    // 提取用户名
                                Collectors.toList()               // 收集为列表
                        )
                ));
        System.out.println("按城市分组获取用户列表:" + cityCounts);

        Map<String, Long> cityUsers = users.stream()
                .collect(Collectors.groupingBy(
                        user -> user.getAddress().getCity(),  // 分组依据：城市名称
                        Collectors.counting()                 // 统计每个分组的数量
                ));
        System.out.println("按城市分组并统计个数:" + cityUsers);
    }


    // 拼接
    public static void joined() {
        String joined = users.stream()
                .map(User::getName)
                .collect(Collectors.joining(", "));
        System.out.println("拼接后的名字:" + joined);
    }

    public static void main(String[] args) {
        foreach();
        filter();
        distinct();
        group();
        map();
        joined();
    }

    /**
     * optional
     */

    // 基础用法
    public void OptionalBasicExample() {
        // 创建 Optional
        Optional<String> optional = Optional.ofNullable(getNullableValue());

        // 安全获取值
        // 存在则返回值，否则返回默认值
        String value = optional.orElse("default");
        optional.ifPresent(v -> System.out.println("Value exists: " + v)); // 值存在时执行操作
    }

    private String getNullableValue() {
        // 模拟可能返回 null 的方法
        return Math.random() > 0.5 ? "data" : null;
    }

    // 链式操作
    public void chainExample() {
        User user = new User("张三", new Address("北京"));
        // 链式操作
        Optional<String> city = Optional.of(user)
                .map(User::getAddress)
                .map(Address::getCity);
        city.ifPresent(c -> System.out.println("City: " + c));

        // 或者直接写作
        Optional.of(user)
                .map(User::getAddress)
                .map(Address::getCity)
                .ifPresent(c -> System.out.println("City (Optional): " + c));

        // 链式异常
        String result = Optional.of(user)
                .map(User::getName)
                .filter(name-> !name.isEmpty())
                .orElseThrow(() -> new IllegalArgumentException("name cannot be empty"));
    }
}
