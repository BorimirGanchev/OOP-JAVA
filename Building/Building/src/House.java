public abstract class House extends  Building{
    @Override
        public double getPricePerMonth(){
            return 1000;
        }
    @Override
        public double estimateExpenses(int months){
        return 100 * months;
    }
}
