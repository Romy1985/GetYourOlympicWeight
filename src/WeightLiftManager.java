import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by r.ceuleers on 29-9-2016.
 */
public class WeightLiftManager {
    private final Map<String, Atlete> atletes;

    public WeightLiftManager() {
        atletes = new HashMap<>();
    }

    @Override
    public Atlete findAtlete(String email) {
        Atlete atlete = atletes.get(email);

        if (atlete == null ) {
            AtleteDAO atleteDAO = new AtleteDAO();
            atlete = atlete.findAtlete(email);
    }

}


}



        if (member == null) {
            // Member may not have been loaded from the database yet. Try to
            // do so.
            MemberDAO memberDAO = new MemberDAO();
            member = memberDAO.findMember(membershipNumber);

            if (member != null) {
                // Member successfully read. Now read its loans.
                LoanDAO loanDAO = new LoanDAO();
                List<Loan> loans = loanDAO.findLoans(member);

                for (Loan loan : loans) {
                    member.addLoan(loan);
                }

                // And read the reserverations from the database.
                ReservationDAO reservationDAO = new ReservationDAO();
                List<Reservation> reservations = reservationDAO.findReservations(member);

                for (Reservation reservation : reservations) {
                    member.addReservation(reservation);
                }

                // Cache the member that has been read from the database, to
                // avoid querying the database each time a member is needed.
                members.put(membershipNumber, member);
            }
        }

        return member;
    }