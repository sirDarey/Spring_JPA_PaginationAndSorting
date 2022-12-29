package sirdarey;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class AddressService {
	
	@Autowired
	AddressRepo addressRepo;
	
	@PostConstruct
	public void initDB() {
		List<Address> addresses = IntStream.rangeClosed(1, 200)
				.mapToObj(i -> new Address("City"+i, "AddressType"+new Random().nextInt(100)))
				.collect(Collectors.toList());
		addressRepo.saveAll(addresses);
	}
	
	public List<Address> addressList () {
		return addressRepo.findAll();
	}
	
	public List<Address> sortAddressList (String field) {
		return addressRepo.findAll(Sort.by(Direction.DESC, field));
	}
	
	public Page<Address> paginateAddressList (int offset, int pageSize) {
		return addressRepo.findAll(PageRequest.of(offset, pageSize));
	}

	public Page<Address> paginateAndSortAddressList(int offset, int pageSize, String field) {
		return addressRepo.findAll(PageRequest.of(offset, pageSize)
				.withSort(Sort.by(Direction.DESC, field)));
	} 
}
