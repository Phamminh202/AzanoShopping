package com.example.azanoshop.service;

import com.example.azanoshop.entity.Account;
import com.example.azanoshop.entity.dto.AccountDto;
import com.example.azanoshop.entity.dto.CredentialDto;
import com.example.azanoshop.entity.myenum.AccountStatus;
import com.example.azanoshop.repository.AccountRepository;
import com.example.azanoshop.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    final AccountRepository accountRepository;

    final PasswordEncoder passwordEncoder;

    public Account register(AccountDto accountDto) {
       Account account = Account.builder()
               .username(accountDto.getUsername())
               .fullname(accountDto.getFullname())
               .email(accountDto.getEmail())
               .phone(accountDto.getPhone())
               .address(accountDto.getAddress())
               .thumbnail(accountDto.getThumbnail())
               .detail(accountDto.getDetail())
               .password(passwordEncoder.encode(accountDto.getPassword())) // ma hoa mat khau
               .role(accountDto.getRole())
               .status(accountDto.getStatus())
               .build();
       return accountRepository.save(account);
    }

    public Account login() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //tao account theo username trong account
        Account account = accountRepository.findByUsername(username);
        //tao danh sach quyen(1.ng dung co nhieu quyen)
        //co the tao ra table quyen rieng mapping n-n vs account

        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (account.getRole() == 1){
            //them quyen theo truong role trong account
            authorities.add(new SimpleGrantedAuthority("user"));
        }else if (account.getRole() == 2){
            authorities.add(new SimpleGrantedAuthority("admin"));
        }else if (account.getRole() == 0){
            authorities.add(new SimpleGrantedAuthority("guest"));
        }
        //tao doi tuong user detail theo thong tin username, pass va quyen duoc lay ra o tren
        //trong do pass la password da duoc ma hoa

        return  new User(account.getUsername(),account.getPassword(),authorities);
    }

    public boolean matchPassword(String rawPassword, String hashPassword){
        return passwordEncoder.matches(rawPassword, hashPassword);
    }

    public CredentialDto generateCredential(UserDetails userDetail, HttpServletRequest request) {
        String accessToken = JWTUtil.generateToken(userDetail.getUsername(),
                userDetail.getAuthorities().iterator().next().getAuthority(),
                request.getRequestURI().toString(),
                JWTUtil.ONE_DAY * 7);

        String refreshToken = JWTUtil.generateToken(userDetail.getUsername(),
                userDetail.getAuthorities().iterator().next().getAuthority(),
                request.getRequestURI().toString(),
                JWTUtil.ONE_DAY * 14);
        return new CredentialDto(accessToken, refreshToken);
    }
    public Page<Account> search(String search, int page, int limit){
        return accountRepository.findAllByFirstNameOrLastNameOrAddressOrEmailOrPhoneOrUsernameContains(search, PageRequest.of(page, limit));
    }

    public Page<Account> findByStatus(AccountStatus status, int page, int limit){
        return accountRepository.findAllByStatusEquals(status, PageRequest.of(page, limit));
    }

    public Page<Account> findByRole(String role, int page, int limit){
        return accountRepository.findAllByRoleEquals(role, PageRequest.of(page, limit));
    }

    public Page<Account> findByCreateBetween(LocalDateTime min, LocalDateTime max, int page, int  limit){
        return accountRepository.findAllByCreateAtBetween(min, max, PageRequest.of(page, limit));
    }

    public Page<Account> findByUpdateBetween(LocalDateTime min, LocalDateTime max, int page, int  limit){
        return accountRepository.findAllByUpdateAtBetween(min, max, PageRequest.of(page, limit));
    }

    public Page<Account> findByDeleteBetween(LocalDateTime min, LocalDateTime max, int page, int  limit){
        return accountRepository.findAllByDeleteAtBetween(min, max, PageRequest.of(page, limit));
    }

    public Optional<Account> findById(String id){
        return accountRepository.findById(id);
    }

    public Page<Account> findAll(int page, int limit){
        return accountRepository.findAll(PageRequest.of(page, limit));
    }

}
