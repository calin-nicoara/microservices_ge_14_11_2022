package ro.esolacad.msge.checkoutservice.checkout;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class OrderSaga {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ShopOrder shopOrder;

    private Step step;

    public enum Step {
        APPROVE_PAYMENT, RESERVE_STOCK, CHECK_CUSTOMER, CHECK_STOCK_LATER, SEND_DELIVERY, COMPLETE_ORDER, CANCELLED;
//        String nextStep;
//
//        private Step(String nextStep) {
//            this.nextStep=nextStep;
//        }
    }
}
