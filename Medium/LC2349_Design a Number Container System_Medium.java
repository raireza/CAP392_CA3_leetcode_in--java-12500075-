class NumberContainers {
    HashMap<Integer, Integer> map = new HashMap<>();
    HashMap<Integer, TreeSet<Integer>> nums = new HashMap<>();

    public NumberContainers() {
        
    }

    public void change(int index, int number) {
        if (map.containsKey(index)) {
            int old = map.get(index);
            nums.get(old).remove(index);
        }

        map.put(index, number);

        nums.putIfAbsent(number, new TreeSet<>());
        nums.get(number).add(index);
    }

    public int find(int number) {
        if (!nums.containsKey(number) || nums.get(number).isEmpty()) {
            return -1;
        }

        return nums.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
