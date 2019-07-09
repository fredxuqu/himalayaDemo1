package himalayaJava8.stream;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author: anna
 * @create on: 2019-07-10 12:00 AM
 * @description:
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Transaction> list = Lists.newArrayList();
        list.add(new Transaction("USD", 1200D, 1000));
        list.add(new Transaction("USD", 2200D, 2000));
        list.add(new Transaction("SGC", 1200D, 1000));
        list.add(new Transaction("HKD", 3200D, 1000));
        Map<String, List<Transaction>> map =
                list.stream()
                    .filter((Transaction t) -> t.getPrice() > 1000)
                    .collect(groupingBy(Transaction::getCurrency));
        map.keySet().forEach(key->{
            List<Transaction> transactions = map.get(key);
            System.out.println(key);
            transactions.forEach(System.out::println);
        });
    }
}

@Data
@AllArgsConstructor
@ToString
class Transaction {
    private String currency;
    private Double price;
    private Integer count;
}
