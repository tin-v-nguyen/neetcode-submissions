class MedianFinder {
    Queue<Integer> left;
    Queue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        right = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }
    
    public void addNum(int num) {
        if (!left.isEmpty() && num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        if (left.size() - right.size() > 1) {
            right.offer(left.poll());
        }
        if (right.size() - left.size() > 1) {
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() > right.size()) return left.peek();
        if (left.size() < right.size()) return right.peek();
        return (double) (left.peek() + right.peek()) / 2;
    }
}
