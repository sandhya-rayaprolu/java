
public class MemberConnections {

	// For each Petition signed by the member, print out all the signing Members - this is the first degree of separation
	// add the members printed out to a HashSet
	// call the function recursively for all the members in the fist degree - this gives the second degree of separation

	public void printConnections(Member member){
	    HashSet<Integer> membersPrinted = new HashSet<>();
	    
	    List<Petition> petitions = member.getPetitionsSigned();
	    List<Member> connectedMembers = null;
	    
	    for( Petition p : petitions ){
	        connectedMembers = p.getSigningMembers();
	        for(Member m : connectedMembers){
	            if(!membersPrinted.contains(m.getId())){
	                System.out.println(m.Id());
	                membersPrinted.add(m.Id());
	                printConnections(m);
	            }
	        }
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
