import { IconHeartbeat } from '@tabler/icons-react';
import { Button, PasswordInput, TextInput } from '@mantine/core';
import { useForm } from '@mantine/form';
import { Link } from 'react-router-dom';
import { SegmentedControl } from '@mantine/core';


const RegisterPage = () => {
    const form = useForm({
        mode: 'controlled',
        initialValues: {
            type: "PATIENT",
            email: '',
            password: '',
            confirmPassword: '',
        },

        validate: {
            email: (value) => (/^\S+@\S+$/.test(value) ? null : 'Invalid email'),
            password: (value) => (!value ? 'Password is required' : null),
            confirmPassword: (value, values) => (value === values.password ? null : "Password don't matched ❌"),
        },
    });

    const handleSubmit = (values: typeof form.values) => {
        console.log(values);
    };
    return (
        <>
            <div style={{ background: 'url("/bg.jpg")' }} className='h-screen w-screen !bg-cover !bg-center !bg-no-repeat flex flex-col justify-center items-center'>
                <div className=' py-4 text-pink-500 flex gap-1 items-center '>
                    <IconHeartbeat size={45} stroke={2.5} />
                    <span className='font-heading font-semibold text-5xl'>Pulse</span>
                </div>
                <div className='w-[550px] backdrop-blur-md p-10 py-8 rounded-2xl'>
                    <form onSubmit={form.onSubmit(handleSubmit)} className="flex flex-col gap-5 [&_input::placeholder]:text-white [&_.mantine-Input-input]:!border-white [&_.mantine-Input-input:focus]:!border-pink-400 [&_.mantine-Input-input]:!border [&_input]:!pl-2 [&_svg]:!text-white [&_input]:!text-white">
                        <div className='self-center font-medium font-heading text-2xl text-white'>Register</div>
                        <SegmentedControl {...form.getInputProps('type')} fullWidth size="md" radius="md" color='pink' bg="none" className='[&_*]:!text-white border border-white' data={[{label: 'Patient', value: 'PATIENT'}, {label: 'Doctor', value: 'DOCTOR'}, {label: 'Admin', value: 'ADMIN'}]} />
                        <TextInput
                            variant="unstyled"
                            size='md'
                            radius='md'
                            withAsterisk
                            placeholder="Email"
                            className='transition duration-200 ease-in-out'
                            {...form.getInputProps('email')}
                        />
                        <PasswordInput
                            variant="unstyled"
                            size="md"
                            radius="md"
                            withAsterisk
                            placeholder="Password"
                            className='transition duration-200 ease-in-out'
                            {...form.getInputProps('password')}
                        />
                        <PasswordInput
                            variant="unstyled"
                            size="md"
                            radius="md"
                            withAsterisk
                            placeholder="ConfirmPassword"
                            className='transition duration-200 ease-in-out'
                            {...form.getInputProps('confirmPassword')}
                        />
                        <Button radius="md" type='submit' color='pink'>Register</Button>
                        <div className='text-neutral-100 text-sm self-center'>Have an account? <Link to="/login" className='text-pink-500 text-lg cursor-pointer hover:underline'>Login</Link></div>
                    </form>
                </div>
            </div>
        </>
    )
}

export default RegisterPage