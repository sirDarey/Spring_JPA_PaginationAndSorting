package sirdarey;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@GetMapping
	private DTO<List<Address>> getAddress () {
		List<Address> list = addressService.addressList();
		return new DTO<>(list.size(), list);
	}
	
	@GetMapping("/sort")
	private DTO<List<Address>> getAddressAndSort (@RequestParam String field) {
		List<Address> list = addressService.sortAddressList(field);
		return new DTO<>(list.size(), list);
	}
	
	@GetMapping("/page")
	public DTO<Page<Address>> paginateAddressList (
			@RequestParam int offset, @RequestParam int pageSize) {
		Page<Address> pageList = addressService.paginateAddressList(offset, pageSize);
		return new DTO<>(pageList.getSize(), pageList);
	}
	
	@GetMapping("/page_sort")
	public DTO<Page<Address>> paginateAndSortAddressList (
			@RequestParam int offset, 
			@RequestParam int pageSize, 
			@RequestParam String field) {
		
		Page<Address> pageList = addressService.paginateAndSortAddressList(offset, pageSize, field);
		return new DTO<>(pageList.getSize(), pageList);
	}
}