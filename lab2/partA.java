 /**
     * Part A: (Buggy) mutative method that adds a constant C to each
     * element of an IntList
     *
     * @param lst IntList from Lecture
     */
    public static void addConstant(IntList lst, int c) {
        IntList head = lst;
        while (head != null) { //这里如果写成head.rest!=null最后一个数据没法改
            head.first += c;
            head = head.rest;
        }
    }
