package LibDL.data.caser;

import LibDL.Tensor;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Interactions {

    private int num_users;
    private int num_items;

    private Tensor user_ids;
    private Tensor item_ids;

    private HashMap user_map;
    private HashMap item_map;

    public Interactions(String file_path, HashMap<Integer, Integer> user_map, HashMap<Integer, Integer> item_map) throws FileNotFoundException, IOException {
        int num_user, num_item;
        if (user_map == null || item_map == null) {
            user_map = new HashMap<Integer, Integer>();
            item_map = new HashMap<Integer, Integer>();

            num_user = 0;
            num_item = 0;
        } else {
            num_user = user_map.size();
            num_item = item_map.size();
        }

        ArrayList<Integer> _user_ids = new ArrayList<Integer>();
        ArrayList<Integer> _item_ids = new ArrayList<Integer>();
        /* read users and items from file */
        BufferedReader br = new BufferedReader(new FileReader(new File(file_path)));
        String line;
        while ((line = br.readLine()) != null) {
            String[] substring = line.split(" ");
            _user_ids.add(Integer.valueOf(substring[0]));
            _item_ids.add(Integer.valueOf(substring[1]));
        }
        br.close();
        /* update user and item mapping */
        Iterator<Integer> iterator;
        iterator = _user_ids.iterator();
        while(iterator.hasNext()) {
            int u = iterator.next();
            if (!user_map.containsKey(u)) {
                user_map.put(u, num_user);
                num_user += 1;
            }
        }
        iterator = _item_ids.iterator();
        while(iterator.hasNext()) {
            int i = iterator.next();
            if(!item_map.containsKey(i)) {
                item_map.put(i, num_item);
                num_item += 1;
            }
        }



        this.num_users = num_user;
        this.num_items = num_item;

        this.user_map = user_map;
        this.item_map = item_map;
    }

    public int len() {
        return 0;
    }
}
